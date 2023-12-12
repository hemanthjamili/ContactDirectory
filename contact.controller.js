angular.module('contactdirectory').controller('ContactController', ContactController);

ContactController.$inject = ['$scope', 'Contact'];

function ContactController($scope, Contact){
	$scope.contacts = Contact.query();
	$scope.contact = {};
	
	$scope.buttonText="Submit";
	$scope.saveContact = function() {

		if (isValid($scope.contact)) {  
			if ($scope.contact.id !== undefined) {
				Contact.update($scope.contact, function() {
					$scope.contacts = Contact.query();
					$scope.contact = {};
					$scope.buttonText="Submit";
				});
			} else {
				Contact.save($scope.contact, function() {
					$scope.contacts = Contact.query();
					console.log($scope.contacts);
					$scope.contact = {};
				});
			}
		}
	}

	$scope.updateContact = function(contact) {
		$scope.buttonText="Update";
		$scope.contact = contact;
	}

	$scope.deleteContact = function(contact) {
		contact.$delete({id: contact.id}, function() {
			$scope.contacts = Contact.query();
		});
	}	
}

function isValid(contact) {	
	let namePattern = /^[A-Za-z ]+(?:[\\s][A-Za-z ]+)?$/;
	let emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	let numberPattern = /^(\+91-?)?(\d{3}-?)?(\d{3}-?)?\d{4}$/;

	if (!namePattern.test(contact.firstName)) {
		alert("First Name not Valid")
		return false;
	}
	if (!namePattern.test(contact.lastName)) {
		alert("Last Name not Valid")
		return false;
	}
	if (contact.phoneNumber.length !=10 || !numberPattern.test(contact.phoneNumber)) {
		alert("Phone Number not Valid")
		return false;
	}
	if (!emailPattern.test(contact.email)) {
		alert("Email not Valid")
		return false;
	}
	
	return true;
}