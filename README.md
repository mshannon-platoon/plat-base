# plat-base
## Overview
The plat-base repository is a starting point for initial development out of the box.

### Features

- maven-multi-module project with a single module
- DockerFile preset to be a Rest Web Service
- DockerCompose file with a Postgres DB (TODO: Mongo, Redis Etc.)
- Flyway for change-set management on Postgres
- Setup for Unit Tests
- Setup for Integration Tests


### Roadmap
- Add a controller for User Object with CRUD operations
- Add redis to that controller functionality
- Add ElasticSearch for user lookup functionality and simulate 1+ million users




#### Learnings

- When creating the db.migration folder, ensure that you create the DB folder first, then the MIGRATION folder as it will think that they are the same folder and flyway will not pick up on any migrations


