# Sudoku in Kotlin
Just a simple Sudoku game I made for fun in Kotlin.  
  
This project only contains Kotlin source files and the executable `.jar` file.

---

## Dependencies

To successfully compile and run the project, you need:

- **Kotlin Compiler (`kotlinc`)**
- **Java Runtime Environment (JRE)**

---

### Kotlin Compiler

The Kotlin compiler (`kotlinc`) is required to compile the `.kt` source files into a `.jar`.

**Installation:**

- Official website: [https://kotlinlang.org/docs/command-line.html](https://kotlinlang.org/docs/command-line.html)

#### Quick install instructions:

**Manual download:**  
Download the latest Kotlin compiler (e.g. `kotlin-compiler-2.1.21.zip`) from the [GitHub Releases](https://github.com/JetBrains/kotlin/releases/tag/v2.1.21).  
Unzip it and add the `bin` directory to your system's PATH to access `kotlinc` globally.

**On UNIX-like systems:**  
Use [SDKMAN!](https://sdkman.io/) for easy installation and management of Kotlin versions.  
Install SDKMAN! with:  
```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```
Verify installation by running:  
```bash
sdk version
```
Then install Kotlin:  
```bash
sdk install kotlin
```
Verify installation by running:  
```bash
kotlin -version
```

---

### Java Runtime Environment (JRE)

The Java Runtime Environment is required to run the compiled `.jar` file.

**Installation:**

- Official Oracle JRE/JDK: [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)
- OpenJDK (recommended and open-source):

  ```bash
  sudo apt install openjdk-21-jdk     # Debian/Ubuntu
  sudo pacman -S jdk21-openjdk       # Arch Linux
  ```

Verify installation by running:  
```bash
java -version
```

---

## Usage

Compile the Kotlin source files into a `.jar`:

```bash
./compile.sh
```

Compile and run the project:

```bash
./compile.sh -e
```

Show help:

```bash
./compile.sh --help
```

If no flag is provided, the script will just compile the project.
