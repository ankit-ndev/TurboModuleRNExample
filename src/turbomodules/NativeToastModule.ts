// MyToastApp/src/NativeToastModule.ts

import type { TurboModule } from 'react-native/Libraries/TurboModule/RCTExport';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  show(message: string, duration: 'SHORT' | 'LONG'): void;
}

export default TurboModuleRegistry.get<Spec>('ToastModule');