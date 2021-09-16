## Important!
For run Keycloak:
```dockerfile
docker run -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin quay.io/keycloak/keycloak:15.0.2
```

## Overview
This repository is a part of application ##Education platform##

## Rules

* use templates for creating issues (tasks) and pull requests
* you should create the new tasks in Issue of appropriate project
* the name of task and branch from master should consist of 3 part:
  * GTW - short name of service (repo);
  * -X: - number in order from 0
  * short description - in 3-5 words, describing main idea (don't use this part in branch name
Example: 
     task: GTW-0: create security config  
     branch: GTW-0
* creating issue - in the rihgt sideyou should set up assignees, tag and repository
* when you make pull request - connect it to appropriate task

more to come 

## Troubleshooting
...

## Release Notes
Can be found in [RELEASE_NOTES](RELEASE_NOTES.md).

## Authors
* group of good guys )

## Acknowledgments
...

## License
This project is Apache License 2.0 - see the [LICENSE](LICENSE) file for details
