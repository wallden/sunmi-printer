export interface SunmiPrinterPlugin {  
  printString(options: { contents: string }): Promise<{ results: boolean }>;
  startTransaction(): Promise<void>;
  endTransaction():Promise<void>;
  sendRawData(options:{content:string}):Promise<void>;
  printText(options:{content:string}):Promise<void>;
  setFontZoom(options:{hori:number,veri:number}):Promise<void>;
  cutPaper(options:{style:number,rows:number}):Promise<void>;
}
