import { WebPlugin } from '@capacitor/core';

import type { SunmiPrinterPlugin } from './definitions';

export class SunmiPrinterWeb extends WebPlugin implements SunmiPrinterPlugin {
  startTransaction(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  endTransaction(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  sendRawData(options: { content: string; }): Promise<void> {
    throw new Error('Method not implemented.');
  }
  printText(options: { content: string; }): Promise<void> {
    throw new Error('Method not implemented.');
  }
  setFontZoom(options: { hori: number; veri: number; }): Promise<void> {
    throw new Error('Method not implemented.');
  }
  cutPaper(options: { style: number; rows: number; }): Promise<void> {
    throw new Error('Method not implemented.');
  }
  async discoverPrinters(): Promise<{ results: any[] }> {
    return {
      results: [{
        name: 'Dummy1',
        address: '123456'
      }, {
        name: 'Dummy2',
        address: '456789'
      }]
    };
  }

  async connectPrinter(options: { address: string }): Promise<{ results: boolean }> {
    console.log("options");
    console.log(options);
    return {
      results: true
    };
  }

  async disconnectPrinter(): Promise<{ results: boolean }> {
    return {
      results: true
    };
  }

  async printString(options: { contents: string, is_bold: boolean, is_underline: boolean }): Promise<{ results: boolean }> {
    console.log("options");
    console.log(options);

    return {
      results: true
    };
  }

  async printBarcode(options: { barcode: string }): Promise<{ results: boolean }> {
    console.log("options");
    console.log(options);

    return {
      results: true
    };
  }

  async printCommand(options: { command: string }): Promise<{ results: boolean }> {
    console.log("options");
    console.log(options);

    return {
      results: true
    };
  }

  async openCashRegister(): Promise<{ results: boolean }> {
    return {
      results: true
    };
  }
}
