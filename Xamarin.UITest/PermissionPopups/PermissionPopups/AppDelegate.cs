using Foundation;
using UIKit;

namespace SpeakToMe
{
	[Register ("AppDelegate")]
	public class AppDelegate : UIApplicationDelegate
	{
		public override UIWindow Window { get; set; }


        public override bool FinishedLaunching(UIApplication app, NSDictionary options)
        {

#if ENABLE_TEST_CLOUD
            Xamarin.Calabash.Start();
#endif

            return true;

        }
    }
}
