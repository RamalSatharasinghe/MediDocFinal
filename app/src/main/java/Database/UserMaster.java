package Database;

import android.provider.BaseColumns;

public final class UserMaster {


    private UserMaster(){}

    protected static class Health implements BaseColumns{

        protected static final String TABLE_NAME = "Health";
        protected static final String COLUMN_1 = "age";
        protected static final String COLUMN_2 = "weight";
        protected static final String COLUMN_3 = "height";
        protected static final String COLUMN_4 = "bSugar";
        protected static final String COLUMN_5 = "bPressure";
        protected static final String COLUMN_6 = "cholesterol";




    }




}
