#!/bin/bash

# Salva tutti i file Java
find . -name "*.java" -exec touch {} \;

# Elimina tutti i file .class esistenti
find . -name "*.class" -delete

# Compila tutti i file Java
javac -d . $(find . -name "*.java")

# Esegui il programma
echo "Avvio del programma..."
java Main 