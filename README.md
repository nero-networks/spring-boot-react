# Spring Boot + react

## Overview

Spring boot + react

TBD

## Development setup

### Environment dependencies

- The react front end relies on NPM. 

    Make sure you have the npm command in your execution path.  
    If you need to install node js look here: [Install NPM](#install-npm)


### Preperation

- Run the following command to initialize the generated project structure.

    ```bash
    ./gradlew buildRelease
    ```

### Backend

- To build and start the app in development mode run

    ```bash
    ./gradlew bootRun
    ```
    
- For continuous build and automatic server restarts run

    ```bash
    ./gradlew build -t
    ```

### Frontend

- To build the front end once run

    ```bash
    ./gradlew webpack
    ```
    
- For continuous build run

    ```bash
    ./gradlew webpackWatch
    ```

#### LiveReload

LiveReload is a browser extension for Safari, Chrome and FF, 
which connects to the boot server and triggers page reload on server restart.

#### Full blown autobuild

To build the whole stack continuously you need to run three long-running processes:

- first terminal

    ```bash
    ./gradlew bootRun
    ```
- second terminal

    ```bash
    ./gradlew build -t
    ```
- third terminal

    ```bash
    ./gradlew webpackWatch
    ```

To receive reload triggers in your browser activate the LiveReload extension.

With this setup every change to the project code should trigger the build chain and reload the browser window.
Known exceptions: Static web content. After updating index.html or adding other static content to ./webapp you must trigger  the copy task manually

```bash
./gradlew copyWebappStaticResources
```

## Production build

To build the jar file into ./build/libs/spring-boot-react-app-VERSION.jar run

```bash
./gradlew buildRelease
```

## Install NPM

Download and install the node js release appropriate for your platform from here: [https://nodejs.org/en/download/]

For Linux extract it somewhere and link two executables into a directory in your $PATH 
(e.g. /usr/local/bin or ~/bin).

```bash
cd /opt # or any other path
tar xvf /path/to/your/downloads/node-vX.Y.Z.tar.xz
ln -s node-vX.Y.Z node
cd /usr/local/bin # or any other dir in your $PATH
ln -s /opt/node/bin/node
ln -s /opt/node/bin/npm
```

