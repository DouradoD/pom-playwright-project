# Start from official Playwright image (includes browsers + Node.js)
FROM mcr.microsoft.com/playwright:v1.40.0-jammy

# 1. Install ONLY essential runtime dependencies
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    # Java 17 (required for your tests)
    openjdk-17-jdk \
    # Maven (for Java dependency management)
    maven \
    # Allure CLI dependencies (for report generation)
    curl \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# 2. Install Allure CLI (required for reporting)
ENV ALLURE_VERSION=2.24.0
RUN curl -o allure-${ALLURE_VERSION}.tgz -Ls \
    https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/${ALLURE_VERSION}/allure-commandline-${ALLURE_VERSION}.tgz \
    && tar -zxvf allure-${ALLURE_VERSION}.tgz -C /opt/ \
    && ln -s /opt/allure-${ALLURE_VERSION}/bin/allure /usr/bin/allure \
    && rm -rf allure-${ALLURE_VERSION}.tgz

# 3. Set up workspace
WORKDIR /app

# 4. Cache dependencies efficiently (copies pom.xml first)
COPY pom.xml .
RUN mvn dependency:go-offline || true # Continue if offline fails

# 5. Copy remaining files
COPY . .

# 6. Verify critical tools
RUN java --version && \
    mvn --version && \
    allure --version && \
    npx playwright --version