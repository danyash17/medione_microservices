# medione_microservices

To successfully deploy to K8s cluster:

#### go to k8s dir ->
### kubectl apply -f [kubernetes-discoveryserver.yml](k8s%2Fkubernetes-discoveryserver.yml)
#### go to helm dir
### helm install kafka kafka
### helm install keycloak keycloak
### helm dependencies build (inside env dir - e.g. /prod-env)
### helm install <release-name> <env-name> (e.g. helm install medione prod-env)