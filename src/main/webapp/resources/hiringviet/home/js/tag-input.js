$(function() {
	 var skills = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.obj.whitespace('name'),
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        prefetch: {
            url: 'assets/skills.json',
            filter: function(list) {
                return $.map(list, function(skill) {
                    return { name: skill };
                });
            }
        }
    });

    skills.initialize();

    $('#required-skills').materialtags({
        typeaheadjs: {
            name: 'skills',
            displayKey: 'name',
            valueKey: 'name',
            source: skills.ttAdapter()
        }
    });
})