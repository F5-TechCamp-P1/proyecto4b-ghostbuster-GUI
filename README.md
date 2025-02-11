# Cachagüercus Asturias

**Tremecéi pantasmes d'Asturies, yá tán aquí les cachagüercus!!**

![image](https://github.com/user-attachments/assets/d0bfd5ab-d62a-4cec-a03e-09e3a630b5a6)


## Table of Contents

- Description
- Features
- Getting Started
  - Prerequisites
  - Installation
- Usage
- Testing
- Build
- Feedback and Contributions
- Contact

## Description

**Cachagüercus Asturias** is an interactive application where the player become a Ghost-buster dedicated to protecting the Asturias region from a surge of paranormal activities. Armed with state-of-the-art proton traps and innovative ectoplasmic detectors, your mission is to investigate phenomena in iconic locations across Asturias, capture ghosts, and maintain peace.

## Features

- **Capture Ghosts:** Expand your collection and protect emblematic places in Asturias.
- **View Captured Ghosts:** Analyze characteristics and plan strategies.
- **Release Ghosts:** Free less dangerous or harmless ghosts to make space in your ectoplasmic container.

[Diagram Class](https://drive.google.com/file/d/1mReOgbssg9_G_iuwmYqWHQtXPykidM-A/view?usp=sharing)

## Getting Started

### Prerequisites

- **Java Development Kit (JDK) 21**
- **Maven** (for build management)
- **JUnit** (for testing)
- **Mockito** (for testing)
- **Git** (for version control)

### Installation

1. **Clone the repository:**

   ```
   git clone https://github.com/F5-TechCamp-P1/proyecto4-ghostbuster.git
   ```

2. **Navigate to the project directory:**

   ```
   cd proyecto4-ghostbuster
   ```

3. **Install dependencies:**

   ```
   mvn install
   ```

## Usage

To run the application, execute:

```
mvn exec:java -Dexec.mainClass="dev.cachaguercus.proyecto4"
```

## Testing

Testing is conducted using Test-Driven Development (TDD) with a minimum coverage of 70%. To run tests:

```
mvn test
```

For a coverage report:

```
mvn jacoco:report
```

## Build

To build the project, use:

```
mvn clean package
```

The packaged application will be located in the `target` directory.

## Feedback and Contributions

We welcome feedback and contributions! Please open an issue or submit a pull request on GitHub. Ensure that your contributions align with the project's guidelines and standards.

## Contact

For any inquiries or support, please contact the project maintainers through the GitHub repository's issue tracker.
