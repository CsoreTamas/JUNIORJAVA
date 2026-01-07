void main() {
    MeneInputReader inputHandler = new MeneInputReader();
    ImgMemeService service = new ImgMemeService();

    MemeRequest request = inputHandler.getInput();

    service.createMeme(request);
}
