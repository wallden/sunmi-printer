# @pubq/sunmi-printer

Communicating

## Install

```bash
npm install @pubq/sunmi-printer
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`printString(...)`](#printstring)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### printString(...)

```typescript
printString(options: { contents: string; is_bold: boolean; is_underline: boolean; }) => Promise<{ results: boolean; }>
```

| Param         | Type                                                                        |
| ------------- | --------------------------------------------------------------------------- |
| **`options`** | <code>{ contents: string; is_bold: boolean; is_underline: boolean; }</code> |

**Returns:** <code>Promise&lt;{ results: boolean; }&gt;</code>

--------------------

</docgen-api>
