## Should `name` and `form` attributes be removed?

Looking at the current implementation in the repository, I can see that **`name` and `form` parameters are currently included** in several Material 3 components like:

- `MdSwitch` ([MdSwitch.kt](https://github.com/huanshankeji/compose-html-material/blob/12abf48f57f68c82098b568de5e12f079b48521c/compose-html-material3/src/jsMain/kotlin/com/huanshankeji/compose/html/material3/MdSwitch.kt#L27-L28))
- `MdCheckbox` ([MdCheckbox.kt](https://github.com/huanshankeji/compose-html-material/blob/12abf48f57f68c82098b568de5e12f079b48521c/compose-html-material3/src/jsMain/kotlin/com/huanshankeji/compose/html/material3/MdCheckbox.kt#L27-L28))
- `MdButton` variants ([MdButton.kt](https://github.com/huanshankeji/compose-html-material/blob/12abf48f57f68c82098b568de5e12f079b48521c/compose-html-material3/src/jsMain/kotlin/com/huanshankeji/compose/html/material3/MdButton.kt#L76))

However, I notice that **`MdTextField` does NOT include these parameters** in its current implementation.

### My recommendation: **Keep them**

Here's why:

1. **They ARE properties in Material Web**: While the [Material Web Text Field docs](https://github.com/material-components/material-web/blob/main/docs/components/text-field.md#properties) show them as "properties", they're still valid and functional properties of the underlying web component. Material Web distinguishes between "properties" (JavaScript) and "attributes" (HTML), but both are accessible.

2. **They have semantic meaning for forms**: These attributes are essential for proper HTML form integration:
   - `name`: Identifies the field in form data submission
   - `form`: Associates the input with a form element (enables inputs outside the `<form>` tag)

3. **Consistency across your codebase**: You're already using them in `MdSwitch`, `MdCheckbox`, and button components. Removing them from text fields would create an inconsistency.

4. **Aligns with your guidelines**: From your coding guidelines, this follows:
   - "Type-safe, readable, analyzable" - explicit parameters are clearer than relying on generic `attrs`
   - "high cohesion" - form-related functionality grouped together

### Suggested action:

**Add** `name` and `form` parameters to `MdTextField` (and `MdOutlinedTextField`) to match the pattern used in other form components. This would look like:

```kotlin
@Composable
fun MdFilledTextField(
    // ... existing parameters ...
    value: String? = null,
    name: String? = null,  // Add this
    form: String? = null,  // Add this
    // ... rest of parameters ...
```

This maintains consistency and provides proper form integration support.