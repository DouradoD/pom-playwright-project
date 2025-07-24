# pom-playwright-project


# Running using Dockerfile
```bash
docker build -t playwright-tests .

```

```bash
docker run -it --rm playwright-tests mvn test

```
or 
### Run and generate Allure report
```bash
docker run -it --rm -v "$(pwd)/target:/app/target" playwright-tests mvn test allure:report

```
