public class RomanToInt {
    public int solution(String s){
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'V':
                    res += 5;
                    break;
                case 'I': {
                    if (i == s.length()-1) {
                        res += 1;
                    } else {
                        switch (s.charAt(i + 1)) {
                            case 'V':
                                res += 4;
                                ++i;
                                break;
                            case 'X':
                                res += 9;
                                ++i;
                                break;
                            default:
                                res += 1;
                                break;
                        }
                    } break;
                }


                case 'L':
                    res += 50;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
                case 'X': {
                    if (i == s.length()-1) {
                        res += 10;
                    } else {
                    switch (s.charAt(i + 1)) {
                        case 'L':
                            res += 40;
                            ++i;
                            break;
                        case 'C':
                            res += 90;
                            ++i;
                            break;
                        default:
                            res += 10;
                    }
                            break;
                    }
                }
                break;
                case 'C': {
                    if (i == s.length()-1) {
                        res += 100;
                    } else {
                    switch (s.charAt(i + 1)) {
                        case 'D':
                            res += 400;
                            ++i;
                            break;
                        case 'M':
                            res += 900;
                            ++i;
                            break;
                        default:
                            res += 100;
                    }
                            break;
                    }
                }
                break;
                default:
                    break;
            }

        }
        return res;
    }
}
