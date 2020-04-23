# StateLayout
五种状态，四种布局
1.  四种界面: 加载中, 加载错误,加载为空 ,加载成功
2.  根据不同的状态去切换界面

		public class HomeFragment extends Fragment {
			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container,
					Bundle savedInstanceState) {
				FrameLayout frameLayout=new FrameLayout(getActivity());
				init();  //  在FrameLayout中 添加4种不同的界面
				showPage();//  根据不同的状态显示不同的界面
				show();// 根据服务器的数据 切换状态
				
				return frameLayout;
			}


## 移除父容器


	public class ViewUtils {
		public static void removeParent(View v){
			//  先找到爹 在通过爹去移除孩子
			ViewParent parent = v.getParent();
			//所有的控件 都有爹  爹一般情况下 就是ViewGoup
			if(parent instanceof ViewGroup){
				ViewGroup group=(ViewGroup) parent;
				group.removeView(v);
			}
		}
	}

##  把所有共性的代码提取到BaseFragment  再把一部分代码 摘取到LoadingPage帧布局中
状态切换布局可以使用成熟方案：https://github.com/KingJA/LoadSir
