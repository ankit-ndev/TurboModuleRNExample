// MyToastApp/src/NativeToastModule.ts

import type { TurboModule } from 'react-native/Libraries/TurboModule/RCTExport';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  nativeLog(message: string): void;
}

export default TurboModuleRegistry.get<Spec>('LoggingModule');