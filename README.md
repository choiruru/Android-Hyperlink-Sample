# Android Hyperlink Sample

## Screenshot
![Screenshot](https://raw.githubusercontent.com/choiruru/Android-Hyperlink-Sample/master/device-2016-03-15-120304.png)

## Usage
``` java
String quote = "Nurture your minds with great thoughts. To believe in the heroic makes heroes.";
TextView textView = (TextView)findViewById(R.id.textview);

HyperlinkHelper.createLink(this, textView, quote, "believe", new HyperlinkHelper.OnClick() {
	@Override
	public void onClick() {
		Toast.makeText(MainActivity.this, "Hyperlink clicked", Toast.LENGTH_SHORT).show();
	}
});
```
