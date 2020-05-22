package kr.co.yhw.jickbangcopy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import kr.co.yhw.jickbangcopy.adapters.RoomAdapter;
import kr.co.yhw.jickbangcopy.databinding.ActivityMainBinding;
import kr.co.yhw.jickbangcopy.datas.Room;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    List<Room> rooms = new ArrayList<>();
    RoomAdapter mRoomAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        binding.roomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Room clickedRoom = rooms.get(position);

                Intent myItent = new Intent(mContext, DetailRoomActivity.class);
                myItent.putExtra("room",clickedRoom);
                startActivity(myItent);
            }
        });
    }

    @Override
    public void setValues() {
        addRooms();

        mRoomAdapter = new RoomAdapter(mContext, R.layout.room_list_item, rooms);
        binding.roomListView.setAdapter(mRoomAdapter);


    }

    void addRooms() {
        rooms.add(new Room(7500,"은평구 불광동",4,"불광동의 흔한 집입니다."));
        rooms.add(new Room(28500,"마포구 서교동",2,"신혼부부의 보금자리 서교동.."));
        rooms.add(new Room(5500,"은평구 갈현동",0,"영화 기생충을 체험해보십시오"));
        rooms.add(new Room(3500,"은평구 응암동",-1,"응암동 지하집입니다"));
        rooms.add(new Room(58500,"은평구 신사동",5,"신사동 우리집입니다."));


    }
}
