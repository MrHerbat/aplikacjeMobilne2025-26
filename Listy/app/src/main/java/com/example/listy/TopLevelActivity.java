    package com.example.listy;

    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ListView;

    public class TopLevelActivity extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_top_level);
            AdapterView.OnItemClickListener itemClickListener =
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> listView, View itemView, int position, long id){
                            Intent intent;
                            switch (position){
                                case 0:
                                    intent = new Intent(TopLevelActivity.this, DrinkCategoryActivity.class);
                                    startActivity(intent);
                                    break;
                                case 1:
                                    intent = new Intent(TopLevelActivity.this, SnackCategoryActivity.class);
                                    startActivity(intent);
                                    break;
                                default:
                                    break;
                            }
                        }
                    };
            ListView listView = (ListView) findViewById(R.id.list_options);
            if (listView != null) {
                listView.setOnItemClickListener(itemClickListener);
            } else {
                throw new RuntimeException("ListView with id/list_options not found in activity_top_level layout");
            }
        }



    }
