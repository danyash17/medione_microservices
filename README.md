# medione_microservices

To successfully deploy to K8s cluster:
### kubectl apply -f [kubernetes-discoveryserver.yml](k8s%2Fkubernetes-discoveryserver.yml) (inside k8s foler)
### helm dependencies build (inside env dir - e.g. /prod-env)
### helm install <release-name> <env-name> (e.g. helm install medione prod-env)