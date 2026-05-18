rm -rf ./build
javac -cp "lib/*:src" -d build $(find src -name "*.java")
cp src/main/resources/persistedUserFeeRateMap.json build/
java -cp "lib/*:build" Main