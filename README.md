# UberUX

### Project that demonstrates the entire animation stack present in the Uber app (android)


## Demo

![Demo](https://user-images.githubusercontent.com/12782512/28917901-e7eac470-7864-11e7-87f8-97227d75a721.gif)

## Libraries
1. [FabProgressCircle](https://github.com/JorgeCastilloPrz/FABProgressCircle)
2. [Retrofit](https://github.com/square/retrofit)
3. [RxAndroid](https://github.com/ReactiveX/RxAndroid)
4. [ButterKnife](https://github.com/JakeWharton/butterknife)


## Concepts
**Transitions** -  For sharing elements between activities 
 ```
void startTransition() {

        Intent intent = new Intent(LoginActivity.this, LoginWithPhone.class);

        Pair<View, String> p1 = Pair.create((View) ivBack, getString(R.string.transition_arrow));
        Pair<View, String> p2 = Pair.create((View) ivFlag, getString(R.string.transition_ivFlag));
        Pair<View, String> p3 = Pair.create((View) tvCode, getString(R.string.transition_tvCode));
        Pair<View, String> p4 = Pair.create((View) tvPhoneNo, getString(R.string.transition_tvPhoneNo));
        Pair<View, String> p5 = Pair.create((View) llphone, getString(R.string.transition_llPhone));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1, p2, p3, p4, p5);
        startActivity(intent, options.toBundle());


    }
```
**ViewPagerTransformer** - For performing animations when ViewPager is swiped
  
```
ViewPager.PageTransformer pageTransformer = new ViewPager.PageTransformer() {
        @Override
        public void transformPage(View page, float position) {


            if (position < -1) { 


            } else if (position <= 1) { 

                   // animate here
        
                }

            }
        }
    };
```


**Overlays** - For creating overlays on map

```
 public void addOverlay(LatLng place) {

        GroundOverlay groundOverlay = mMap.addGroundOverlay(new
                GroundOverlayOptions()
                .position(place, 100)
                .transparency(0.5f)
                .zIndex(3)
                .image(BitmapDescriptorFactory.fromBitmap(drawableToBitmap(getDrawable(R.drawable.map_overlay)))));

    }

```
**ValueAnimator** - For animating overlays and polylines

 ```
ValueAnimator tAnimator = ValueAnimator.ofFloat(0, 1);
        tAnimator.setRepeatCount(ValueAnimator.INFINITE);
        tAnimator.setRepeatMode(ValueAnimator.RESTART);
        tAnimator.setInterpolator(new LinearInterpolator());
        tAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
               // animate here
            }
        });

```

**PolyLines** - For drawing lines on map
```
 PolylineOptions greyOptions = new PolylineOptions();
        greyOptions.width(10);
        greyOptions.color(Color.GRAY);
        greyOptions.startCap(new SquareCap());
        greyOptions.endCap(new SquareCap());
        greyOptions.jointType(ROUND);
        greyPolyLine = mMap.addPolyline(greyOptions);

```
## How to use this project

Add your [GoogleMaps](https://developers.google.com/maps/documentation/android-api/) and [GooglePlaces](https://developers.google.com/places/android-api/) key to google_maps_api.xml and turn on direction api from developer console -> You are good to go !


