package th.ac.rmutt.en.dome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {

        this.context = context;
    }

    //*****************************Arrays*****************************
    public int[] slide_image = {

            R.drawable.img_icon1,
            R.drawable.img_icon2,
            R.drawable.img_icon4,
            R.drawable.img_icon3
    };

    public String[] slide_numberRoom = {

            "APARTMENT",
            "ROOM 1",
            "ROOM 2",
            "ROOM 3"
    };

    public String[] slide_dataRoom = {

            "Welcome to My APARTMENT",
            "ROOM 1 price 3000 bath",
            "ROOM 2 price 4000 bath",
            "ROOM 3 price 5000 bath"
    };

    //**************************************************************

    @Override
    public int getCount() {
        return slide_numberRoom.length;
    }

    //************************************************************************

    @Override
    public boolean isViewFromObject( View view, Object object) {
        return view == (RelativeLayout) object;
    }

    //************************************************************************


    @Override
    public Object instantiateItem( ViewGroup container, int position) {

     layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideNumberRoom = (TextView) view.findViewById(R.id.slide_numberRoom);
        TextView slideDataRoom = (TextView) view.findViewById(R.id.slide_dataRoom);

        slideImageView.setImageResource(slide_image[position]);
        slideNumberRoom.setText(slide_numberRoom[position]);
        slideDataRoom.setText(slide_dataRoom[position]);

        container.addView(view);

     return view;

    }

    //************************************************************************


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);

    }
}
