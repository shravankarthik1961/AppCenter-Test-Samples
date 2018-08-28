using System;
using System.IO;
using System.Linq;
using NUnit.Framework;
using Xamarin.UITest;
using Xamarin.UITest.Queries;

namespace UITestDemo.UITest
{
    [TestFixture(Platform.Android)]
    [TestFixture(Platform.iOS)]
    public class Tests
    {
        IApp app;
        Platform platform;

        public Tests(Platform platform)
        {
            this.platform = platform;
        }

        [SetUp]
        public void BeforeEachTest()
        {
            app = AppInitializer.StartApp(platform);
        }

        [Test]
        public void AppLaunches()
        {
            app.Screenshot("First screen.");
        }

        [Test]
        public void ClearTextDemo()
        {
            app.Tap(x => x.Marked("Add"));
            app.Tap(x => x.Text("Item name"));

            app.Screenshot("Before calling ClearText");
            app.ClearText();
            app.EnterText("The test worked!");
            app.Screenshot("Text cleared & replaced");
            app.Back();
        }

        [Test]
        public void SingleQuoteTest()
        {
            app.Tap(x => x.Marked("Add"));
            app.Tap(x => x.Text("Item name"));

            app.Screenshot("Before calling ClearText");
            app.ClearText();

            app.EnterText("Kent's Demo");
            app.Screenshot("Text cleared & replaced");
            app.Tap("Save");

            //below query fails on Android only
            app.Tap(x => x.Marked("Kent's Demo"));
            app.Screenshot("Single Quote Test worked");
        }

        [Test]
        public void ApostropheTest()
        {
            app.Tap(x => x.Marked("Add"));
            app.Tap(x => x.Text("Item name"));

            app.Screenshot("Before calling ClearText");
            app.ClearText();

            app.EnterText("Kent`s Demo");
            app.Screenshot("Text cleared & replaced");
            app.Tap("Save");

            //Query passes even on Android
            app.Tap(x => x.Marked("Kent`s Demo"));
            app.Screenshot("Apostrophe Test worked");
        }
    }
}
