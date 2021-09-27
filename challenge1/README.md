# Challenge 1
Build an app that consists of 3 screens, ie: Splash, Welcome and Home. Each has the following background colour:
1. Splash -> Purple
1. Welcome -> Teal
1. Home -> White

The interactions and behaviour between these screens are outlined below:
1. Launch app, load Splash screen for 3 seconds
1. After Splash screen finishes, load Welcome screen, provide an OK button.
1. If OK button is clicked, load the Home screen.
1. On Home screen, tapping the Back button in bottom navigation should close the app.
1. On subsequent app launches, the Welcome screen should not show.

See gif below describing the behaviour, notes:
* *Gif starts with behaviour from step 1-4*
* *Then shows the step 5 behaviour*
* *Gif then loops indefinitely*

<img src="https://s9.gifyu.com/images/device-2021-09-03-113459.gif" alt="behaviour video" width="400"/>

## Instructions
1. Create a new branch off `main` and implement your solution in the new branch.
2. You can use resources found in the `res` folder.
3. Possible approaches: Compose, Single Activity Multiple Fragments, Multiple Activities, etc.
4. Once you are done, make sure to create a PR merging into `main`.
5. Make sure the solution is demo-able using emulator.