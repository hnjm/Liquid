package com.jonathanfinerty.liquidity.persistence;

import android.content.ContentResolver;
import android.net.Uri;

public class BudgetContract {

    public static final Uri URI = Uri.withAppendedPath(ContractBase.BASE_URI, "budget");

    public static final String TYPE  = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/vnd.com.jonathanfinerty.liquidity.budget";



    public static String PREFERENCES = "budget preferences";

    public static String DATE_PREFERENCE = "budget date";

    public static String AMOUNT_PREFERENCE = "budget amount";

}