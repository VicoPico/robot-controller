# Robot Controller Application

The **Robot Controller Application** is a command-line tool that allows users to control a robot in a grid-based room. Users can define the room dimensions, set the robot's starting position and orientation, and issue commands to move the robot.

---

## Table of Contents

- [Robot Controller Application](#robot-controller-application)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
  - [How to Run Locally](#how-to-run-locally)
    - [Prerequisites](#prerequisites)
    - [Steps to Run Locally](#steps-to-run-locally)
  - [How to Run with Docker](#how-to-run-with-docker)
    - [Prerequisites](#prerequisites-1)
    - [Pull the Image](#pull-the-image)
    - [Run the Application](#run-the-application)
    - [Build the Image Locally (Optional)](#build-the-image-locally-optional)
  - [Usage Instructions](#usage-instructions)
    - [Define Room Dimensions:](#define-room-dimensions)
    - [Set Robot's Starting Position](#set-robots-starting-position)
    - [Issue Commands](#issue-commands)
    - [Visualize the Grid](#visualize-the-grid)
  - [Example](#example)
    - [Input](#input)
    - [Output](#output)
  - [Future Enhancements](#future-enhancements)

---

## Features

- Define custom room dimensions.
- Set the robot's starting position and orientation.
- Issue commands to move the robot (`L` for left, `R` for right, `F` for forward).
- Visualize the robot's position and orientation in the grid.

---

## How to Run Locally

### Prerequisites

- **Java 17 or later** installed on your system.
- **Maven** installed for building the project.

### Steps to Run Locally

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/robot-controller.git
   cd robot-controller
   ```

2. Build the project:

   ```bash
   mvn clean package
   ```

3. Run the application:

   ```bash
   java -jar target/robot-controller-1.0-SNAPSHOT.jar
   ```

---

## How to Run with Docker

The application has been containerized and is available as a Docker image on Docker Hub.

### Prerequisites

- **Docker** installed on your system. You can download it from [Docker's official website](https://www.docker.com/products/docker-desktop).

### Pull the Image

To pull the Docker image from Docker Hub, run:

```bash
docker pull gomezvictor/robot-controller:1.0
```

### Run the Application

To run the application in a Docker container, use:

```bash
docker run --rm -it gomezvictor/robot-controller:1.0
```

### Build the Image Locally (Optional)

If you prefer to build the Docker image locally, use:

```bash
docker build -t robot-controller .
docker run --rm -it robot-controller
```

---

## Usage Instructions

### Define Room Dimensions:

Enter the width and height of the room (positive integers).

### Set Robot's Starting Position

Enter the robot's starting x and y coordinates (within the room bounds).  
Enter the robot's starting direction (N, E, S, W).

### Issue Commands

Enter a sequence of commands:  
L: Turn the robot left.  
R: Turn the robot right.  
F: Move the robot forward.

### Visualize the Grid

The application will display the robot's position and orientation in the grid after processing the commands.

---

## Example

### Input

```bash
Enter the width of the room: 5
Enter the height of the room: 5
Enter the robot´s starting x-coordinate: 2
Enter the robot´s starting y-coordinate: 2
Enter the robot´s starting direction (N, E, S, W): N
Enter a sequence of commands (L for left, R for right, F for forward): LFFR
```

### Output

```bash
[ ] [ ] [ ] [ ] [ ]
[ ] [ ] [ ] [ ] [ ]
[ ] [ ] [←] [ ] [ ]
[ ] [ ] [ ] [ ] [ ]
[ ] [ ] [ ] [ ] [ ]
```

---

## Future Enhancements

- Add support for emojis.
- Allow saving and loading robot configurations.
- Web-based frontend, maybe use Vaadin in a Spring Boot application.
- Replace `System.out.println` with a proper logging framework (e.g., SLF4J with Logback) for better logging practices and configurability.
