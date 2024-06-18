package network.chaintech.cmptooltipdemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmptooltipdemo.composeapp.generated.resources.Res
import cmptooltipdemo.composeapp.generated.resources.ic_button
import cmptooltipdemo.composeapp.generated.resources.ic_comment
import cmptooltipdemo.composeapp.generated.resources.ic_custom_button
import cmptooltipdemo.composeapp.generated.resources.ic_custom_content
import cmptooltipdemo.composeapp.generated.resources.ic_custom_image
import cmptooltipdemo.composeapp.generated.resources.ic_default
import cmptooltipdemo.composeapp.generated.resources.ic_home
import cmptooltipdemo.composeapp.generated.resources.ic_menu
import cmptooltipdemo.composeapp.generated.resources.ic_message_alert
import cmptooltipdemo.composeapp.generated.resources.ic_profile
import cmptooltipdemo.composeapp.generated.resources.ic_top_right_arrow
import cmptooltipdemo.composeapp.generated.resources.temp1
import cmptooltipdemo.composeapp.generated.resources.temp2
import cmptooltipdemo.composeapp.generated.resources.temp3
import cmptooltipdemo.composeapp.generated.resources.temp4
import kotlinx.coroutines.delay
import network.chaintech.cmptooltip.CMPTooltipBox
import network.chaintech.cmptooltip.state.TooltipBoxArrowDirection
import network.chaintech.cmptooltip.state.TooltipBoxConfig
import network.chaintech.cmptooltip.state.rememberTooltipBoxState
import network.chaintech.cmptooltipdemo.theme.AppTheme
import network.chaintech.cmptooltipdemo.theme.ColorPalette
import org.jetbrains.compose.resources.painterResource


data class GridViewTooltipDataModel(
    var defaultTooltip: Modifier,
    var defaultImageTooltip: Modifier,
    var defaultButtonTooltip: Modifier,
    var customButtonTooltip: Modifier,
    var customImageTooltip: Modifier,
    var customContentTooltip: Modifier,
)

@Composable
internal fun App() = AppTheme {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = ColorPalette.white
    ) {
        TooltipViewExample()
    }
}

@Composable
fun TooltipViewExample() {
    var showTooltip by remember { mutableStateOf(false) }
    val tooltipState = rememberTooltipBoxState()
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    LaunchedEffect(Unit) {
        delay(500)
        showTooltip = true
    }

    CMPTooltipBox(
        state = tooltipState,
        showTooltip = showTooltip,
        onTooltipCompleted = {
            showTooltip = false
        }
    ) {
        Box(
            modifier = Modifier
                .background(ColorPalette.backgroundPrimary)
                .windowInsetsPadding(WindowInsets.statusBars)
        ) {
            Scaffold(
                scaffoldState = scaffoldState,
                backgroundColor = ColorPalette.backgroundPrimary,
                modifier = Modifier
                    .fillMaxSize(),
                topBar = { },
                floatingActionButton = { },
                bottomBar = { }
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        item {
                            TopWelcomeView()

                            Spacer(modifier = Modifier.height(25.dp))

                            ButtonGridView(
                                gridViewTooltipModifier = GridViewTooltipDataModel(
                                    defaultTooltip = Modifier
                                        .markForSimpleTooltip(
                                            index = 0,
                                            tooltipBoxConfig = TooltipBoxConfig(
                                                backgroundColor = Color.White,
                                                tooltipBoxArrowDirection = TooltipBoxArrowDirection.Top,
                                                arrowHeadSize = 25f,
                                                arrowColor = Color.White,
                                                titleTextStyle = TextStyle(
                                                    color = Color(0xFF333333),
                                                    fontWeight = FontWeight.Bold,
                                                ),
                                                descriptionTextStyle = TextStyle(
                                                    color = Color(0xFF8B8B8B)
                                                )
                                            ),
                                            title = "Default Tooltip",
                                            description = "This is Default Tooltip with title and description"
                                        ),
                                    defaultImageTooltip = Modifier
                                        .markForImageTooltipBox(
                                            index = 1,
                                            tooltipBoxConfig = TooltipBoxConfig(
                                                backgroundColor = Color.White,
                                                tooltipBoxArrowDirection = TooltipBoxArrowDirection.Bottom,
                                                arrowHeadSize = 25f,
                                                arrowColor = Color.White,
                                                titleTextStyle = TextStyle(
                                                    color = Color(0xFF333333),
                                                    fontWeight = FontWeight.Bold,
                                                ),
                                                descriptionTextStyle = TextStyle(
                                                    color = Color(0xFF8B8B8B)
                                                )
                                            ),
                                            title = "Tooltip with Default Image",
                                            description = "This is Default Tooltip with title and description",
                                            imageName = Res.drawable.temp1,
                                        ),
                                    defaultButtonTooltip = Modifier
                                        .markForButtonTooltipBox(
                                            index = 2,
                                            tooltipBoxConfig = TooltipBoxConfig(
                                                backgroundColor = Color.White,
                                                tooltipBoxArrowDirection = TooltipBoxArrowDirection.Top,
                                                arrowHeadSize = 25f,
                                                arrowColor = Color.White,
                                                titleTextStyle = TextStyle(
                                                    color = Color(0xFF333333),
                                                    fontWeight = FontWeight.Bold,
                                                ),
                                                descriptionTextStyle = TextStyle(
                                                    color = Color(0xFF8B8B8B)
                                                )
                                            ),
                                            title = "Default Tooltip with Button",
                                            description = "This is Default Tooltip with title and description",
                                            buttonTitle = "Click Me",
                                            buttonClickEvent = {

                                            },
                                        ),
                                    customButtonTooltip = Modifier
                                        .markForButtonTooltipBox(
                                            index = 3,
                                            tooltipBoxConfig = TooltipBoxConfig(
                                                backgroundColor = Color.White,
                                                tooltipBoxArrowDirection = TooltipBoxArrowDirection.Top,
                                                arrowHeadSize = 25f,
                                                arrowColor = Color.White,
                                                titleTextStyle = TextStyle(
                                                    color = Color(0xFF333333),
                                                    fontWeight = FontWeight.Bold,
                                                    textAlign = TextAlign.Center
                                                ),
                                                descriptionTextStyle = TextStyle(
                                                    color = Color(0xFF8B8B8B),
                                                    textAlign = TextAlign.Center
                                                )
                                            ),
                                            title = "Tooltip with Custom Button",
                                            description = "This is custom button tooltip with title and description",
                                            customButtonContent = {
                                                Box(
                                                    modifier = Modifier
                                                        .background(
                                                            shape = RoundedCornerShape(20.dp),
                                                            color = Color(0xFF4579FF)
                                                        )
                                                        .padding(
                                                            horizontal = 30.dp,
                                                            vertical = 8.dp
                                                        )
                                                        .clickable(
                                                            interactionSource = MutableInteractionSource(),
                                                            indication = null
                                                        ) {

                                                        }
                                                ) {
                                                    Text(
                                                        text = "Click Me",
                                                        textAlign = TextAlign.Center,
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 14.sp,
                                                        color = Color.White,
                                                    )
                                                }
                                            }
                                        ),
                                    customImageTooltip = Modifier
                                        .markForImageTooltipBox(
                                            index = 4,
                                            tooltipBoxConfig = TooltipBoxConfig(
                                                backgroundColor = Color.White,
                                                tooltipBoxArrowDirection = TooltipBoxArrowDirection.Top,
                                                arrowHeadSize = 25f,
                                                arrowColor = Color.White,
                                                titleTextStyle = TextStyle(
                                                    color = Color(0xFF333333),
                                                    fontWeight = FontWeight.Bold,
                                                    textAlign = TextAlign.Center
                                                ),
                                                descriptionTextStyle = TextStyle(
                                                    color = Color(0xFF8B8B8B),
                                                    textAlign = TextAlign.Center
                                                )
                                            ),
                                            title = "Tooltip with Custom Image",
                                            description = "This is Custom Image tooltip with title and description",
                                            customImageContent = {
                                                Image(
                                                    painter = painterResource(Res.drawable.temp2),
                                                    contentDescription = Res.drawable.temp2.toString(),
                                                    contentScale = ContentScale.Fit,
                                                    modifier = Modifier
                                                        .size(92.dp)
                                                        .border(
                                                            width = 2.dp,
                                                            color = Color(0xFFBEEAFF),
                                                            shape = CircleShape
                                                        )
                                                        .clip(CircleShape)
                                                )
                                            },
                                        ),
                                    customContentTooltip = Modifier
                                        .applyCustomTooltipBox(
                                            index = 5,
                                            tooltipBoxConfig = TooltipBoxConfig(
                                                backgroundColor = Color(0xFFFFF0E0),
                                                tooltipBoxArrowDirection = TooltipBoxArrowDirection.Top,
                                                arrowHeadSize = 25f,
                                                arrowColor = Color(0xFFFFF0E0)
                                            ),
                                            content = {
                                                CustomTooltipView()
                                            },
                                        )
                                )
                            )

                            Spacer(modifier = Modifier.height(25.dp))

                            VarietiesView()

                            Spacer(
                                modifier = Modifier
                                    .height(105.dp)
                                    .windowInsetsPadding(WindowInsets.safeDrawing)
                            )
                        }
                    }

                    BottomNavBar(
                        modifier = Modifier
                            .align(alignment = Alignment.BottomCenter)
                            .clickable {
                                showTooltip = true
                            },
                        menuTooltipModifier = Modifier
                            .markForTooltipWithButtonAndImage(
                                index = 6,
                                tooltipBoxConfig = TooltipBoxConfig(
                                    backgroundColor = Color.White,
                                    tooltipBoxArrowDirection = TooltipBoxArrowDirection.Top,
                                    arrowHeadSize = 25f,
                                    arrowColor = Color.White,
                                    titleTextStyle = TextStyle(
                                        color = Color(0xFF333333),
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center,
                                    ),
                                    descriptionTextStyle = TextStyle(
                                        color = Color(0xFF8B8B8B),
                                        textAlign = TextAlign.Center,
                                    )
                                ),
                                title = "Tooltip with Default Image + Button",
                                description = "This is default Image + Button Image tooltip with title and description",
                                imageName = Res.drawable.temp3,
                                buttonTitle = "Click Me",
                                buttonClickEvent = {
                                    showTooltip = false
                                },
                            ),
                    )
                }
            }
        }
    }
}

@Composable
fun TopWelcomeView() {
    Column(
        modifier = Modifier
            .padding(top = 48.dp)
            .padding(horizontal = 15.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Good afternoon!",
            color = ColorPalette.textPrimary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Welcome User",
                color = ColorPalette.white,
                fontSize = 35.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )

            Image(
                painter = painterResource(Res.drawable.ic_top_right_arrow),
                contentDescription = Res.drawable.ic_top_right_arrow.toString(),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(30.dp)
                    .height(23.dp)
            )
        }
    }
}

@Composable
fun ButtonGridView(gridViewTooltipModifier: GridViewTooltipDataModel) {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Box(
                modifier = gridViewTooltipModifier.defaultTooltip
                    .background(
                        shape = RoundedCornerShape(25.dp),
                        color = ColorPalette.greenPrimary
                    )
                    .weight(0.54f)

            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 25.dp, vertical = 28.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_default),
                        contentDescription = Res.drawable.ic_default.toString(),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(38.dp)
                    )

                    Text(
                        text = "Default\nTooltip",
                        color = ColorPalette.black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                    )
                }
            }

            Box(
                modifier = gridViewTooltipModifier.defaultImageTooltip
                    .background(
                        shape = RoundedCornerShape(25.dp),
                        color = ColorPalette.white
                    )
                    .padding(horizontal = 25.dp, vertical = 28.dp)
                    .weight(0.38f)
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_profile),
                    contentDescription = Res.drawable.ic_profile.toString(),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(46.dp)
                        .align(Alignment.Center)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Box(
                modifier = gridViewTooltipModifier.defaultButtonTooltip
                    .background(
                        shape = RoundedCornerShape(25.dp),
                        color = ColorPalette.white
                    )
                    .padding(horizontal = 25.dp, vertical = 28.dp)
                    .weight(0.38f)
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_button),
                    contentDescription = Res.drawable.ic_button.toString(),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(46.dp)
                        .align(Alignment.Center)
                )
            }

            Box(
                modifier = gridViewTooltipModifier.customButtonTooltip
                    .background(
                        shape = RoundedCornerShape(25.dp),
                        color = ColorPalette.orangePrimary
                    )
                    .weight(0.54f)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 17.dp, vertical = 28.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_custom_button),
                        contentDescription = Res.drawable.ic_custom_button.toString(),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(64.dp)
                            .height(34.dp)
                    )

                    Text(
                        text = "Custom\nButton",
                        color = ColorPalette.black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Box(
                modifier = gridViewTooltipModifier.customImageTooltip
                    .background(
                        shape = RoundedCornerShape(25.dp),
                        color = ColorPalette.bluePrimary
                    )
                    .weight(0.54f)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 25.dp, vertical = 28.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_custom_image),
                        contentDescription = Res.drawable.ic_custom_image.toString(),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(38.dp)
                    )

                    Text(
                        text = "Custom\nImage",
                        color = ColorPalette.black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                    )
                }
            }

            Box(
                modifier = gridViewTooltipModifier.customContentTooltip
                    .background(
                        shape = RoundedCornerShape(25.dp),
                        color = ColorPalette.white
                    )
                    .padding(horizontal = 25.dp, vertical = 28.dp)
                    .weight(0.38f)
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_custom_content),
                    contentDescription = Res.drawable.ic_custom_content.toString(),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(46.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun VarietiesView() {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Tooltip Varieties",
                color = ColorPalette.textSecondary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "View all",
                    color = ColorPalette.textSecondary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                )

                Image(
                    painter = painterResource(Res.drawable.ic_top_right_arrow),
                    contentDescription = Res.drawable.ic_top_right_arrow.toString(),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(19.dp)
                        .height(15.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Tooltip with Custom Button",
                color = ColorPalette.white,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Title, text content and a customize button",
                color = ColorPalette.textOther,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(14.dp))

            HorizontalDivider(
                modifier = Modifier, thickness = 1.dp,
                color = ColorPalette.divider
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Tooltip with Custom Button + Image",
                color = ColorPalette.white,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Title, text content and customize button + image",
                color = ColorPalette.textOther,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(14.dp))

            HorizontalDivider(
                modifier = Modifier, thickness = 1.dp,
                color = ColorPalette.divider
            )
        }
    }
}

@Composable
fun BottomNavBar(modifier: Modifier = Modifier, menuTooltipModifier: Modifier) {
    Box(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .fillMaxWidth()
            .padding(horizontal = 53.dp)
            .background(
                shape = RoundedCornerShape(20.dp),
                color = ColorPalette.white
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 27.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_home),
                contentDescription = Res.drawable.ic_home.toString(),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(22.dp)
            )

            Box(
                modifier = menuTooltipModifier
                    .background(
                        shape = RoundedCornerShape(15.dp),
                        color = ColorPalette.orangeSecondary
                    )
                    .padding(13.dp)
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_menu),
                    contentDescription = Res.drawable.ic_menu.toString(),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(22.dp)
                )
            }

            Image(
                painter = painterResource(Res.drawable.ic_comment),
                contentDescription = Res.drawable.ic_comment.toString(),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(22.dp)
            )
        }
    }
}


@Composable
fun CustomTooltipView() {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .background(
                color = Color(0xFFFFF0E0),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(Res.drawable.temp4),
            contentDescription = Res.drawable.ic_message_alert.toString(),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(77.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Tooltip with Custom Content",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFFC17D10),
        )

        Spacer(modifier = Modifier.height(9.dp))

        Text(
            text = "This is Default Tooltip with title and description",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color(0xFF8B8B8B)
        )

        Spacer(modifier = Modifier.height(18.dp))

        Box(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(20.dp),
                    color = Color(0xFF6CB14C)
                )
                .padding(horizontal = 30.dp, vertical = 8.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) {

                }
        ) {
            Text(
                text = "Click Me",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White,
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}