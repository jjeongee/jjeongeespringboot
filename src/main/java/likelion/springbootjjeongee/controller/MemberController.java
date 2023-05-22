
/*
*스프링이 처음 뜰 때 스프링 컨테이너 통 생성
* controller 어노테이션(주석인데 문법 에러 체크, 코드 자동생성, 특정기능 시행 가능)이 있으면
*MemberController 객체 생성 -> 스프링에 넣어둠 -> 스프링이 관리
**/
@Controller //배달원. 웹사이트에서 받은 주소 mapping -> service에 전달
@RequestMapping("members")
public class MemberController {
    /*
    * MemberService -> new로 사용하면 : 다른 컨트롤러들이 MemberService 사용할때마다 새로운 객체 생성
* 매번 새로운 객체를 생성한다
* 하나의 객체를 공유해서 사용한다
    **/
    private final MemberService memberService;

/*
     * (예시)
     * 이 것은 생성자입니다.
     * @Autowired라는 어노테이션은 MemberController 객체를 실행해야 할 때 필요한 의존성을 주입해달라고 선언하기 위해 명시하는 어노테이션이며, 생성자 주입 방식을 선언하고 있습니다.
     * MemberController의 필드를 MemberService 타입으로 선언하였지만, 생성자 paramer에는 MemberServiceImpl이 주입되게 함으로써 느슨한 결합(Loosen Coupling)을 구현하였습니다.
     * @참고 : 실제로는 MemberController 생성자의 파라미터에 MemberServiceImpl이 아니라 MemberService로 쓰여있어도 스프링이 알아서 구현체 클래스의 인스턴스 (MemberServiceImpl memberserviceimpl)를 넣어주게 됩니다.
     *       즉, public MemberController(MemberService memberService) {this.memberService = memberService;} 와 같이 작성해도 에러가 없고, 이게 사실 정석입니다.
     *       아래처럼 작성해 둔 이유는, 실제로는 아래와 같이 동작한다는 것을 여러분 눈으로 먼저 보길 바랐던 제 마음이었습니다. 
		 *       지금, MemberController의 필드가 MemberService 타입의 데이터인데, 생성자로 주입되는 것은 MemberServiceImpl 타입이라는 것을 충분히 음미하시길 바랍니다.
     **/
    @Autowired
    public MemberController(MemberServiceImpl memberServiceImpl) { //MemberController 생성시 memberService 넣어줌(의존관계)
        this.memberService = memberServiceImpl;
    }
    
    /*
    * 새로운 멤버를 등록하는 화면을 연결시키기 위한 코드
    * templates/members/createMemberForm 경로로 접근 -> 화면에 멤버 목록 띄움
     **/
    @GetMapping("new")
    public String createForm(Model model) { //새로운 Model 객체 생성
        model.addAttribute("memberForm", new Member()); //새로운 Member객체를 Model 객체에 도입
        return "members/createMemberForm";
    }
    
    /*
     * new회원(회원가입)이 완료되면 홈 화면으로 되돌아간다
     **/
    @PostMapping("new")
    public String create(Member member) {
        memberService.save(member);
        return "redirect:/"; //home으로
    }
    
    /*
     * new가 아닌 새로운 멤버로 들어오면 templates/members/memberList로 이동
     * model.addAttribute의 key값, value값 형태로 정보 전달
     **/
    @GetMapping("/members")
    public String findAll(Model model) {
        List<Member> memberList = memberService.findAll();
        model.addAttribute("memberList",memberList);
        return "members/memberList";
    }
}
/**
 * Controller -> 외부 요청 받기
 * service -> 비즈니스 로직 만들기
 * Repository -> 데이터 저장하기
 */
