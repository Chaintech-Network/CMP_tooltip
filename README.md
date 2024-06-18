# CMPTooltip

A CMPTooltip is custom tooltip library for Compose Multiplatform for Android and iOS.

![CMPTooltips](https://github.com/ChainTechNetwork/CMP_tooltip/assets/143475887/1108b4b7-d540-4edb-945a-fd6feb7f1a9d)

## Installation

1. Add the dependency to your `build.gradle.kts` file:

```
commonMain.dependencies {
    implementation("network.chaintech:cmp-tooltip:1.0.0")
}
```

2. Define Your CMPTooltipBox Components

```kotlin
var showTooltip by remember { mutableStateOf(false) }
val tooltipState = rememberTooltipBoxState()

CMPTooltipBox(
   state = tooltipState,
   showTooltip = showTooltip,
   onTooltipCompleted = {
       showTooltip = false
   }
) {
    // Your main UI content goes here
}
```

3. Simple Tooltip:

```kotlin
IconButton(
    onClick = { /* Handle menu icon click */ },
    modifier = Modifier
      .markForSimpleTooltip(
          index = 0,
          title = "Menu",
          description = "Click here to open the menu",
          tooltipBoxConfig = TooltipBoxConfig(
              backgroundColor = Color.White,
              // Customize other tooltip properties as needed
          )
      )
) {
    Icon(Icons.Filled.Menu, contentDescription = "Menu")
}
```

4. Tooltip with Button

```kotlin
IconButton(
    onClick = { /* Handle menu icon click */ },
    modifier = Modifier.markForButtonTooltipBox(
        index = 0,
        title = "Menu",
        description = "Click here to open the menu",
        buttonTitle = "OK",
        buttonClickEvent = {
            // Handle button click event
        },
        tooltipBoxConfig = TooltipBoxConfig(
            backgroundColor = Color.White,
        )
    )
) {
    Icon(Icons.Filled.Menu, contentDescription = "Menu")
}
```

5. Tooltip with Image

```kotlin
IconButton(
    onClick = { /* Handle menu icon click */ },
    modifier = Modifier.markForImageTooltipBox(
        index = 0,
        title = "Menu",
        description = "Click here to open the menu",
        imageName = R.drawable.menu_icon,
        tooltipBoxConfig = TooltipBoxConfig(
            backgroundColor = Color.White,
        )
    )
) {
    Icon(Icons.Filled.Menu, contentDescription = "Menu")
}
```

6. Tooltip with Button and Image

```kotlin
IconButton(
    onClick = { /* Handle menu icon click */ },
    modifier = Modifier.markForTooltipWithButtonAndImage(
        index = 0,
        title = "Menu",
        description = "Click here to open the menu",
        imageName = R.drawable.menu_icon,
        buttonTitle = "OK",
        buttonClickEvent = {
            // Handle button click event
        },
        tooltipBoxConfig = TooltipBoxConfig(
            backgroundColor = Color.White,
        )
    )
) {
    Icon(Icons.Filled.Menu, contentDescription = "Menu")
}
```

7. Custom Tooltip Content

```kotlin
IconButton(
    onClick = { /* Handle menu icon click */ },
    modifier = Modifier.applyCustomTooltipBox(
        index = 0,
        tooltipBoxConfig = TooltipBoxConfig(
            backgroundColor = Color.White,
            arrowDirection = TooltipBoxArrowDirection.Top,
            arrowHeadSize = 25f,
            arrowColor = Color.White,
            // Customize other tooltip properties as needed
        ),
        content = {
            Text(
                text = "Custom Tooltip Content",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    )
) {
    Icon(Icons.Filled.Menu, contentDescription = "Menu")
}
```

## Screenshot
![CMPTooltip_screenshot](https://github.com/ChainTechNetwork/CMP_tooltip/assets/143475887/8f4378fd-31fc-400c-8b01-3506c98bbd0b)


- For Demo [Checkout This Class](https://github.com/ChainTechNetwork/CMP_tooltip/blob/main/composeApp/src/commonMain/kotlin/network/chaintech/cmptooltipdemo/App.kt)

- [Medium Article](https://medium.com/@manishdabhi1223_25861/15b68aa04ff4) for detailed explaination.

- Connect us on [LinkedIn](https://www.linkedin.com/showcase/mobile-innovation-network)

