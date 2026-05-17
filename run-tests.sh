rm -rf ./build
javac -cp "lib/*:src" -d build $(find src -name "*.java")
java -jar lib/junit-platform-console-standalone-1.14.4.jar --class-path build --scan-class-path