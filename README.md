# Setting microservice system

## Driver for Docker loki

[Reference](https://grafana.com/docs/loki/latest/clients/docker-driver/configuration/)

1. Change the `daemon.json` at `/etc/docker` to `./etc.docker.daemon.json`

2. Install the plugin
    ```bash
    docker plugin install grafana/loki-docker-driver:latest --alias loki --grant-all-permissions
    ```
3. Restart Docker service
   ```bash
   sudo systemctl daemon-reload
   sudo systemctl restart docker
   ```


## Grafana credentials
 - admin
 - admin

Go to datasources and add Loki, enter host url: `http://loki:3100`