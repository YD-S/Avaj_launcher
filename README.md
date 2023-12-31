<div align="center">
  <img src="https://raw.githubusercontent.com/YD-S/42_project-readmes/master/banners/42-dark.png"/>
</div>
<a href='https://profile.intra.42.fr/users/ysingh' target="_blank">
        <img alt='42 (oscuro)' src='https://img.shields.io/badge/Málaga-black?style=flat&logo=42&logoColor=white'/>
</a>

# Avaj Launcher

## Table of Contents
- [About](#about)
- [Usage](#usage)
- [Simulation Scenario](#simulation-scenario)
- [Author](#author)

## About

`Avaj Launcher` is a project at [42](https://www.42.fr/) that simulates the behavior of aircraft in a simplified aviation environment. The goal is to implement a program that reads a scenario file, simulates aircraft movements, and produces a log of the events. This project enhances your understanding of file I/O, simulation, and object-oriented programming.

## Usage

To use `Avaj Launcher` in your project, follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone [https://github.com/YD-S/Avaj_launcher.git]
   ```
2. Cd into the project directory:

   ```
   cd avaj_launcher
   ```
3. Compile the program:

   ```bash
    make
    ```
4. Run the executable with the scenario file:

   ```bash
    ./avaj_launcher [scenario_file]
   ```
   
## Simulation Scenario

The scenario file should have the following format:

    25
    Baloon B1 2 3 20
    Baloon B2 1 8 66
    JetPlane J1 23 44 32
    Helicopter H1 654 33 20
    Helicopter H2 22 33 44
    Helicopter H3 98 68 99
    Baloon B3 102 22 34
    JetPlane J2 11 99 768
    Helicopter H4 223 23 54


The first line of the file contains a positive integer number. This number represents the number of times the simulation is run. In our case, this will be the number of times a weather change is triggered.

## Author

Yashdev Singh (Ysingh)