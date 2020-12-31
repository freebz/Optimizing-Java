// 종료화 안 하기

class File_error {};

class File {
public:
  File(const char* Filename) : _h_File(std::fopen(Filename, "w+")) {
    if (_h_File == NULL) {
      throw File_error();
    }
  }

  // 해체자
  ~File() { std::fclose(_h_File); }

  void write(const char* str) {
    if (std::fputs(str, _h_File) == EOF) {
      throw File_error();
    }
  }

  void write(const char* buffer, std::size_t numc) {
    if (numc != 0 && std::fwrite(buffer, numc, 1, _h_File) == 0) {
      throw File_error();
    }
  }

private:
  std::File* _h_File;
};
