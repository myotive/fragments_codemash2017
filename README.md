Fragments: The solution (and cause of) all of Android's problems
=====================================

Samples for my CodeMash 2017 talk "Fragments: The solution (and cause of) all of Android's problems".

[Todo: Link to Slides](http://www.google.com)

# Building

To build, install and run a debug version, run this from the root of the project:

```
  ./gradlew assembleDebug
```

# Screens
![Fragments Sample](https://github.com/myotive/fragments_codemash2017/blob/master/screenshots/Jan-11-2017%2012-13-39.gif?raw=true)

# References

* [What the Fragment - Adam Powell](https://www.youtube.com/watch?v=k3IT-IJ0J98)
* [Square - Advocating Against Android Fragments](https://medium.com/square-corner-blog/advocating-against-android-fragments-81fd0b462c97#.oocb23bhn)
* [Square - Flow and Mortar](https://medium.com/square-corner-blog/simpler-android-apps-with-flow-and-mortar-5beafcd83761#.sp63y1ae7)
* [Google Samples - Android Architecture](https://github.com/googlesamples/android-architecture)

#### BLOGS
* [Dianne Hackborn on Android Architecture](https://plus.google.com/+DianneHackborn/posts/FXCCYxepsDU)
  - "Android as a system doesn't care how the app is structured internally as long as the app uses proper APIs to interact with other apps and the system."
* http://www.briangriffey.com/blog/1 - (No Fragments, Rich Views)
* http://softwareengineering.stackexchange.com/questions/244771/why-use-android-fragments
* http://www.droidjournal.com/blog/reviews/2015/06/26/review-advocating-against-android-fragments.html
* https://www.quora.com/As-of-2015-does-Square-still-advocate-against-using-fragments-in-Android-Development
* https://medium.com/@jacquesgiraudel/fragments-too-complex-google-io-android-n-etc-75e6a7310b6d#.4cq6ic8wx

#### Response to Square's original post
* http://www.droidjournal.com/blog/reviews/2015/06/26/review-advocating-against-android-fragments.html
* http://www.droidjournal.com/blog/reviews/2015/06/27/squares-hypothetical-response-to-our-review.html
* https://github.com/xxv/android-lifecycle

#### Fragment specific
* https://medium.com/@jacquesgiraudel/fragments-too-complex-google-io-android-n-etc-75e6a7310b6d#.h4lvrjkxf
* https://medium.com/@jacquesgiraudel/problem-with-restoring-fragments-from-the-backstack-945dc3f7f5a5#.i0hcragwi
* https://www.pluralsight.com/blog/software-development/android-fragments
* https://medium.com/inloop/demystifying-androids-commitallowingstateloss-cb9011a544cc#.q1c3s5o1q
* http://www.androiddesignpatterns.com/2013/08/fragment-transaction-commit-state-loss.html
* https://realm.io/news/360andev-david-hope-fragments-activities-android-beginner/
* http://android.codeandmagic.org/why-android-dialogfragment-confuses-me-part1/

#### MVP
* https://github.com/Syhids/android-architecture/tree/todo-mvp-fragmentless

#### View-Based Architecture
* https://medium.com/square-corner-blog/advocating-against-android-fragments-81fd0b462c97#.uhgmitn8a
* https://medium.com/square-corner-blog/simpler-android-apps-with-flow-and-mortar-5beafcd83761#.sp63y1ae7
* https://www.bignerdranch.com/blog/an-investigation-into-flow-and-mortar/
* https://realm.io/news/using-flow-mortar/
* https://medium.com/@artem_zin/m-model-from-mvc-mvp-in-android-flow-and-mortar-bd1e50c45395#.u8jnnk4yl
* https://medium.com/@Zhuinden/saying-no-to-fragments-and-activities-creating-view-driven-applications-with-flow-8f7d02315442#.qk2kywrjt
* https://dzone.com/articles/android-abandoning-the-activity-stack-using-flowmo
* http://hannesdorfmann.com/mosby/
* http://hannesdorfmann.com/mosby/mvp/
* http://hannesdorfmann.com/mosby/viewstate/

#### Libraries
* https://github.com/bluelinelabs/Conductor
* https://github.com/sockeqwe/mosby
* https://github.com/konmik/nucleus
* https://github.com/grandcentrix/ThirtyInch
* https://github.com/square/flow
* https://github.com/square/mortar
* https://github.com/frankiesardo/icepick

#### Podcasts
* http://fragmentedpodcast.com/episodes/6/
* https://player.fm/series/the-context-androiddev/episode-1-architecture-of-modern-android-apps-with-hannes-dorfmann

#### Videos
* [What the Fragment? - Google I/O 2016](https://www.youtube.com/watch?v=k3IT-IJ0J98)
* [Android application architecture: Get ready for the next billion! - Google I/O 2016](https://www.youtube.com/watch?v=70WqJxymPr8)
* [Mateusz Herych, IG – The ultimate guide to MVP pattern on Android](https://www.youtube.com/watch?v=RWKFmvadXOI)
* [Model View Presenter by Michael Cameron](https://www.youtube.com/watch?v=AoqL1PN8hCk)
* [MCE 2015 - Pierre-Yves Ricau - Mortar & Flow](https://www.youtube.com/watch?v=R8NbpkpSuw8)
* https://teamtreehouse.com/library/build-a-blog-reader-android-app/exploring-the-masterdetail-template/the-modelviewcontroller-mvc-design-pattern-2
* https://caster.io/courses/mvp/
