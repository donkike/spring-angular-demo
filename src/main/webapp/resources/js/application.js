var app = angular.module("MyApp", []);

app.controller("MainCtrl", function($scope, peopleService) {

    $scope.people = [];

    peopleService.fetchAll()
        .success(function(data) {
            $scope.people = data;
        }).error(function(data, status) {
            alert("Unable to load data (" + status + ").");
        });

     $scope.remove = function(personId) {
        peopleService.remove(personId)
            .success(function() {
                for (var i = 0; i < $scope.people.length; i++) {
                    var person = $scope.people[i];
                    if (personId == person.id) {
                        $scope.people.splice(i, 1);
                        break;
                    }
                }
                alert("Record successfully removed.");
            }).error(function(data, status) {
                alert("Unable to remove record (" + status + ").");
            });
     };

     $scope.create = function(person) {
        peopleService.create(person)
            .success(function(data) {
                $scope.people.push(data);
                $scope.newPerson = {};
                alert("Record created successfully.");
            }).error(function(data, status) {
                alert("Unable to create record (" + status + ").")
            });
     };

});

app.factory("peopleService", function($http) {
    return {
        fetchAll: function() {
            return $http.get("api/people");
        },
        remove: function(personId) {
            return $http.delete("api/people/" + personId);
        },
        create: function(person) {
            return $http.post("api/people", person);
        }
    }
});