# Kubernetes - Spring Boot with Mongo | Persistent Data Base| HPA | Rolling UPdate
## Demo Link
https://drive.google.com/file/d/1IlaqZsdoQbLMoEJWqrTMuxXRArqqC_bI/view?usp=drive_link
### One drive
https://nagarro-my.sharepoint.com/:v:/p/mayank_singh/EfxeTstVcRdPqDfw4aRW8DwBl_6qotIURk9LKbFnoE5e2A?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&e=E73bC4

## spring boot project
https://github.com/meiyanksingh/Mayank_3149723KubernetesAndDevopsAdvance/tree/main/KubernetesAssignment/nagp

## Docker Hub images
### Spring Boot project
https://hub.docker.com/search?q=mayanksnagp2024%2F
### Mongo Project
https://hub.docker.com/_/mongo

## Api Service Deployment
https://github.com/meiyanksingh/Mayank_3149723KubernetesAndDevopsAdvance/tree/main/KubernetesAssignment/microservice_deployment

## Steps: 

### 1. Run a Docker Engine

### 2. Create a jar file of spring project

### 3. Go to the project path 
```bash
   cd KubernetesAssignment\nagp
```

## 4. Create a image
```bash
   docker build -t mks_nagp . 
```
### 5. Create a tag for the image
```bash
   docker tag mks_nagp mayanksnagp2024/mks_nagp
```
### 6. Push it to docker hub
```bash
docker push mayanksnagp2024/mks_nagp
```
   

### 7. Start Minikube 
```bash
   minikube start
```

## 8. Deploy mongo database

   Switch to path KubernetesAssignment\mongo_db_deployment and apply below commands:
```bash
   kubectl apply -f mongo-ms-configmap.yaml
   kubectl apply -f mongo-ms-secret.yaml
   kubectl apply -f mongo-ms-service.yaml
   kubectl apply -f mongo-ms-statefulset
```
### 9. Verify the data base deployment
```bash
   kubectl get pods
```
   Ensure that database pod running successfully

### 10. Create database in mongo shell
```bash
    kubectl exec -it mongo-0 -- /bin/bash
    mongosh
    use admin
    show dbs
    use movie_db

 db.createUser({
   user: "myuser",
   pwd:  "password",
   roles: [
     { role: "readWrite", db: "movie_db" }
   ]
});
```
### 11. Deploy Spring boot application

   Switch to path KubernetesAssignment\microservice_deployment and apply below command
   ```bash
kubectl apply -f nagp-ms-api-configmap.yaml
   kubectl apply -f nagp-ms-api-deployment.yaml
   kubectl apply -f nagp-ms-api-service.yaml
```

### 12. Verify the application pod
```bash
    kubectl get pods
```
   Ensure that the Spring Boot application pod is running successfully.

### 13. Access the application
```bash
    minikube service api-service --url
```
   Open the url on browser
    
## 14. Perform the rolling update
    a. Switch to path  KubernetesAssignment\nagp
    b. Create New image 
       docker build -t mks_nagp:v2 .
    c. Create a tag for new image
       docker tag mks_nagp:v2 mayanksnagp2024/mks_nagp:v2
    d. Push the image to docker hub
       docker push mayanksnagp2024/mks_nagp:v2
    e. Update the image  in  nagp-ms-api-deployment.yaml i.e  new image is mayanksnagp2024/mks_nagp:v2
    f. Switch to deployment file path and apply updated deployment
       kubectl apply -f .\nagp-ms-api-deployment.yaml
       kubectl get deployment
    g. Get the status of the Deployment
       kubectl rollout status deployment/api-deployment)
    h. Describe the Deployment to see detailed status
       kubectl rollout status deployment/api-deployment
    i. Get the list of pods to see the new and old pods
       kubectl get pods -l app=api
    j. Rollback to a Previous Version
       kubectl rollout undo deployment/api-deployment

## 15.  Verify the persistence of data by deleting mongo pod
    a. Delete the mongo db pod 
       kubectl delete pod mongo-0
    b. check running pod
       kubectl get pod
    c. Check the web application data is persisted

## 16.   Horizontal pod scalling
    a. Switch to path KubernetesAssignment\hpa and apply below command
       kubectl apply -f nagp-ms-api-hpa.yaml.txt
    b. switch to path KubernetesAssignment\metric and apply below command
       kubectl apply . 
    b. Apply below command to check hpa
       kubectl get hpa
    b. Apply below command to check replicas   
       kubectl get pods
       
Notes: mayanksnagp2024 is docker hub user name . mks_nagp is image name. 
       

     

