# SampleJavaMVCbackend
1. Template of Spring MVC java.
2. Able to change current database in DBConfiguration.java Application.properties -> parent Application-dev.properties -> dev Application-prod.properties -> prod
3. Application-prod.properties: template setting for heroku environment
4. Procfile: For heroku environment reference
5. Deploy Step 
   Download git and Heroku CLI -> set pom.xml, envConfiguration, Application.properties -> Runs as Maven Build -> set Procfile, make sure
   the path of jar is right -> cd to the workspace -> git init, git add . , git commit -m "commit", heroku git:remote -a tomwebbackend, 
   git push heruko master
6. push an existing repository from the command line
    git remote add origin https://github.com/avan106206/SampleJavaMVCbackend.git     
    git push -u origin master
