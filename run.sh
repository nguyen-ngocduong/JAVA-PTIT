#!/bin/bash
#./run.sh <TenFile>
# run.sh - Script to compile and run Java files in the current directory

if [ $# -eq 0 ]; then
    echo "Usage: ./run.sh <JavaFileName>"
    echo "Example: ./run.sh BASIC001"
    echo ""
    echo "Available Java files:"
    ls -1 *.java 2>/dev/null | sed 's/.java$//'
    exit 1
fi

FILENAME=$1

# Remove .java extension if provided
FILENAME=${FILENAME%.java}

if [ ! -f "${FILENAME}.java" ]; then
    echo "Error: File ${FILENAME}.java not found!"
    exit 1
fi
#Biên dịch file nguồn Java thành mã máy (file .class).
echo "Compiling ${FILENAME}.java..."
javac "${FILENAME}.java"
# Kiểm tra xem quá trình biên dịch có lỗi cú pháp không.
if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi

echo "Running ${FILENAME}..."
echo "-------------------"
java "$FILENAME"

# Xoa file .class sau khi chay xong
echo ""
echo "Cleaning up .class files..."
rm -f *.class


echo "Done!"

