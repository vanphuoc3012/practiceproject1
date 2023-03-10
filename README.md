# practiceproject1

### How to use
- Database: Oracle 19c
- Add username, password and database url in application.properties
- 'Tutorials' table will be automatically created and imported data when app start

### API

#### - POST: '/api/tutorials'
Add new tutorial

![img_1.png](img_1.png)

#### - GET: '/api/tutorials'
Get all tutorials in database

![img_2.png](img_2.png)

#### - GET: '/api/tutorials/:id'
Get a specific tutorial by ID

![img_3.png](img_3.png)

#### - PUT: '/api/tutorials/:id'
Update specific tutorial by ID

![img_4.png](img_4.png)

#### - DELETE: '/api/tutorials/:id'
Delete specific tutorial by ID

![img_5.png](img_5.png)

#### - DELETE: '/api/tutorials'
Delete all tutorial in database

![img_6.png](img_6.png)

#### - GET: '/api/tutorials/published'
Get only published tutorials

![img_7.png](img_7.png)

#### - GET: '/api/tutorials?title=[keyword]'
Get tutorials contain 'keyword'

![img_8.png](img_8.png)