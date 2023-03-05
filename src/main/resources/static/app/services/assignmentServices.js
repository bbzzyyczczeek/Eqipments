angular.module('app')
.constant('ASSIGNMENT_ENDPOINT', '/api/rent/:id')
.factory('Assignment', function($resource, ASSIGNMENT_ENDPOINT) {
    return $resource(ASSIGNMENT_ENDPOINT);
})
.service('AssignmentService', function() {
    this.save = assignment => assignment.$save();
})
.service('AssignmentEndService', function($http) {
    this.save = assignmentId => $http.post(`/api/rent/${assignmentId}/end`);
});