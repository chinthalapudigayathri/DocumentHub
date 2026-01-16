#check if kubernetes is running or not
kubectl version --client
kubectl config get-contexts
kubectl cluster-info

#for mongodb
kubectl apply -f mongodb-deployment.yaml

#for application
kubectl apply -f documenthub-deployment.yaml

#check pods
kubectl get pods

#check services
kubectl get services

#you must see this
minikube service documenthub-service


