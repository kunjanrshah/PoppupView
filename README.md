#Dialog example exprience from android developlment.

##Tour and Resource

[http://developer.android.com/guide/topics/ui/dialogs.html](http://developer.android.com/guide/topics/ui/dialogs.html)

##Issue

###getActivity() is not defined.

The getActivity() method gives the context of the Activity. You can use YourActivityName.class instead of it.

The method getActivity() is normally used in fragments to get the context of the activity in which they are inserted or inflated.

	AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.class);
	// or 
	AlertDialog.Builder builder = new AlertDialog.Builder(this);

ref: [http://stackoverflow.com/questions/14480129/getactivity-where-it-is-defined](http://stackoverflow.com/questions/14480129/getactivity-where-it-is-defined)