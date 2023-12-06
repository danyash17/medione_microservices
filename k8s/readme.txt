1) Init all configmaps
kubectl apply -f <file>
2) Init MYSQL secret & storage
..same
3) Import MYSQL data
kubectl -n <namespace> exec -i <pod name> -- mysql -u root -proot -e "CREATE DATABASE IF NOT EXISTS medione;"
kubectl -n <namespace> exec -i <pod name> -- mysql -u root -proot medione < dbdata/medione_dump.sql
4) Deploy in following order:
mysql -> configserver -> eurekaserver -> mmdoctor -> mmpatient -> mmvisits -> keycloak -> gatewayserver
