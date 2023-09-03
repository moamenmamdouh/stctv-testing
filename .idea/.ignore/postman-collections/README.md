# Introduction 
This project intended to keep our postman collections updated and shared among the team.
It should contain a collection for each DSL service, so we as a team should keep updating this as we go.

# Guidelines
To use, add or edit a collection, follow the next points:
* Collection name should follow the pattern:
  * serviceName.postman_collection.json
* Each collection should contain a variable for each environment URL.
![collectionVariable.png](resources%2FcollectionVariable.png)
* Base urls should be replaced by the activated collection variable.
![basURL.png](resources%2FbasURL.png)
* Each collection should contain a folder for each version.
* Each folder should contain a single request for each route.
![fileStructure.png](resources%2FfileStructure.png)