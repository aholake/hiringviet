package vn.com.hiringviet.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.CompanyPhotoDAO;
import vn.com.hiringviet.model.ChangeLog;
import vn.com.hiringviet.model.CompanyPhoto;
import vn.com.hiringviet.util.Utils;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyPhotoDAOImpl.
 */
@Repository
@Transactional
public class CompanyPhotoDAOImpl extends CommonDAOImpl<CompanyPhoto> implements CompanyPhotoDAO {

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CompanyPhotoDAO#createPhotoBanner(java.lang.Integer, vn.com.hiringviet.model.CompanyPhoto)
	 */
	@Override
	public boolean createPhotoBanner(Integer companyId,
			CompanyPhoto companyPhoto) {

		Integer result = 1;
		Query query = null;
		StringBuffer insertChangeLogSQL = new StringBuffer();
		ChangeLog changeLog = Utils.createDefaultChangeLog();
		insertChangeLogSQL.append("INSERT INTO change_log (created_date, status, updated_date) VALUES (:createdDate, 1, :updatedDate)");
		query = getSession().createSQLQuery(insertChangeLogSQL.toString());
		query.setParameter("createdDate", changeLog.getCreatedDate());
		query.setParameter("updatedDate", changeLog.getUpdatedDate());

		result = query.executeUpdate();
		if (result <= 0) {
			return false;
		}

		StringBuffer getLastIdSQL = new StringBuffer();
		getLastIdSQL.append("SELECT change_log.id FROM change_log ORDER BY id desc LIMIT 0,1");
		query = getSession().createSQLQuery(getLastIdSQL.toString());
		Integer clId = (Integer) query.uniqueResult();

		StringBuffer insertCommentSQL = new StringBuffer();
		insertCommentSQL.append("INSERT INTO company_photo (title, description, photo, photoKey, company_id, type, change_log_id) ");
		insertCommentSQL.append("VALUES (:title, :description, :photo, :photoKey, :companyId, :type, :changeLogId)");
		query = getSession().createSQLQuery(insertCommentSQL.toString());
		query.setParameter("title", companyPhoto.getTitle());
		query.setParameter("description", companyPhoto.getDescription());
		query.setParameter("photo", companyPhoto.getPhoto());
		query.setParameter("photoKey", companyPhoto.getPhotoKey());
		query.setParameter("companyId", companyId);
		query.setParameter("type", 1);
		query.setParameter("changeLogId", clId);

		result = query.executeUpdate();
		if (result <= 0) {
			return false;
		}

		return true;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.dao.CompanyPhotoDAO#deletePhotoBanner(java.lang.Integer)
	 */
	@Override
	public boolean deletePhotoBanner(Integer id) {

		Query query = null;
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE company_photo WHERE id = :id");
		query = getSession().createSQLQuery(sql.toString());
		query.setParameter("id", id);

		if (query.executeUpdate() > 0) {
			return true;
		}
		
		return false;
	}

}
