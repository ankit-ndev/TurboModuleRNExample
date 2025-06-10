import React from "react";
import {
  Pressable,
  SafeAreaView,
  ScrollView,
  StyleSheet,
  Text,
  View,
} from "react-native";
import ToastModule from "./src/turbomodules/NativeToastModule";
import NativeLoggingModule from "./src/turbomodules/NativeLoggingModule";

function App(): React.JSX.Element {
  const showShortToast = () => {
    ToastModule?.show("This is a short Toast!", "SHORT");
  };

  const showLongToast = () => {
    ToastModule?.show("This is a long Toast!", "LONG");
  };

  const printNativeLogs = () => {
    NativeLoggingModule?.nativeLog(
      "Hello there, welcome to turbo modules native logs"
    );
  };

  return (
    <SafeAreaView>
      <ScrollView>
        <View style={styles.sectionContainer}>
          <Text style={styles.headerTitle}>Turbo Module Toast Example</Text>
          <Pressable style={styles.button} onPress={showShortToast}>
            <Text style={styles.buttonTitle}>Short Toast</Text>
          </Pressable>
          <Pressable style={styles.button} onPress={showLongToast}>
            <Text style={styles.buttonTitle}>Long Toast</Text>
          </Pressable>
          <Pressable style={styles.button} onPress={printNativeLogs}>
            <Text style={styles.buttonTitle}>Print logs</Text>
          </Pressable>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 80,
    paddingHorizontal: 24,
  },
  headerTitle: {
    fontSize: 28,
    fontWeight: "600",
    color: "black",
  },
  button: {
    height: 50,
    width: 200,
    backgroundColor: "green",
    justifyContent: "center",
    alignItems: "center",
    marginTop: 30,
  },
  buttonTitle: {
    fontSize: 24,
    fontWeight: "600",
    color: "white",
  },
});

export default App;
