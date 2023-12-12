angular.module('contactdirectory').factory('Contact', Contact);

Contact.$inject = [ '$resource' ];

function Contact($resource) {
	var resourceUrl = 'api/v2/contact/:id';

	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}